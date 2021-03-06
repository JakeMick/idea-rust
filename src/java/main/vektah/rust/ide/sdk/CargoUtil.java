package vektah.rust.ide.sdk;

import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import vektah.rust.config.RustConfig;
import vektah.rust.config.RustConfigService;

public class CargoUtil {
	public static String findCargoPath() {
		RustConfig config = ServiceManager.getService(RustConfigService.class).getState();

		if (config == null) {
			return "cargo";
		}

		return config.getCargoBinary();
	}

	@NotNull
	public static VirtualFile findTomlOf(Project project) {
		return findTomlIn(project.getBaseDir());
	}

	@NotNull
	private static VirtualFile findTomlIn(VirtualFile dir) {
		VirtualFile file = dir.findChild("Cargo.toml");

		if (file == null) {
			throw new RuntimeException("Unable to find Cargo.toml for this project");
		}

		return file;
	}

	public static String findCargoWorkingDirectory(Project project) {
		return CargoUtil.findTomlOf(project).getParent().getCanonicalPath();
	}

	public static String findOutCrateNameOf(VirtualFile contentRoot) throws Exception {
		String[] tomlLines = new String(findTomlIn(contentRoot).contentsToByteArray()).split("\n");
		for (String line : tomlLines) {
			if (line.startsWith("name = \"")) {
				return line.split("\"")[1];
			}
		}

		throw new Exception("Can't find out name of the crate");
	}
}
