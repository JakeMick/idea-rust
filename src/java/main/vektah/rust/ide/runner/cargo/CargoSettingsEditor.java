package vektah.rust.ide.runner.cargo;

import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SettingsEditor;
import org.jetbrains.annotations.NotNull;
import vektah.rust.i18n.RustBundle;

import javax.swing.*;
import java.awt.*;

public class CargoSettingsEditor extends SettingsEditor<CargoRunConfiguration> {
    private static String BENCH_TARGET  = RustBundle.message("runner.cargo.target.bench");
    private static String BUILD_TARGET  = RustBundle.message("runner.cargo.target.build");
    private static String CLEAN_TARGET  = RustBundle.message("runner.cargo.target.clean");
    private static String DOC_TARGET    = RustBundle.message("runner.cargo.target.doc");
    private static String TEST_TARGET   = RustBundle.message("runner.cargo.target.test");
    private static String RUN_TARGET    = RustBundle.message("runner.cargo.target.run");
    private static String UPDATE_TARGET = RustBundle.message("runner.cargo.target.update");
    private JComboBox  target;
    private JTextField workingDir;

    @Override
    protected void resetEditorFrom(CargoRunConfiguration config) {
        if (config.getTarget() == CargoTarget.BENCH) {
            target.setSelectedItem(BENCH_TARGET);
        } else if (config.getTarget() == CargoTarget.BUILD) {
            target.setSelectedItem(BUILD_TARGET);
        } else if (config.getTarget() == CargoTarget.CLEAN) {
            target.setSelectedItem(CLEAN_TARGET);
        } else if (config.getTarget() == CargoTarget.DOC) {
            target.setSelectedItem(DOC_TARGET);
        } else if (config.getTarget() == CargoTarget.TEST) {
            target.setSelectedItem(TEST_TARGET);
        } else if (config.getTarget() == CargoTarget.RUN) {
            target.setSelectedItem(RUN_TARGET);
        } else if (config.getTarget() == CargoTarget.UPDATE) {
            target.setSelectedItem(UPDATE_TARGET);
        }


        workingDir.setText(config.getWorkingDirectory());
    }

    @Override
    protected void applyEditorTo(CargoRunConfiguration config) throws ConfigurationException {
        if (target.getSelectedItem().equals(BENCH_TARGET)) {
            config.setTarget(CargoTarget.BENCH);
        } else if (target.getSelectedItem().equals(BUILD_TARGET)) {
            config.setTarget(CargoTarget.BUILD);
        } else if (target.getSelectedItem().equals(CLEAN_TARGET)) {
            config.setTarget(CargoTarget.CLEAN);
        } else if (target.getSelectedItem().equals(DOC_TARGET)) {
            config.setTarget(CargoTarget.DOC);
        } else if (target.getSelectedItem().equals(TEST_TARGET)) {
            config.setTarget(CargoTarget.TEST);
        } else if (target.getSelectedItem().equals(RUN_TARGET)) {
            config.setTarget(CargoTarget.RUN);
        } else if (target.getSelectedItem().equals(UPDATE_TARGET)) {
            config.setTarget(CargoTarget.UPDATE);
        }

        config.setWorkingDirectory(workingDir.getText());
    }

    @NotNull
    @Override
    protected JComponent createEditor() {
        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(0, 2));

        panel.add(new JLabel(RustBundle.message("runner.cargo.label.target")));
        panel.add(target = new JComboBox(new String[]{
            BENCH_TARGET,
            BUILD_TARGET,
            CLEAN_TARGET,
            DOC_TARGET,
            TEST_TARGET,
            RUN_TARGET,
            UPDATE_TARGET
        }));

        panel.add(new JLabel(RustBundle.message("runner.cargo.label.workdir")));
        panel.add(workingDir = new JTextField());

        return panel;
    }
}
