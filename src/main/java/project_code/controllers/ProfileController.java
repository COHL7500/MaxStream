package project_code.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.event.ActionEvent;

public class ProfileController {

    @FXML
    private ColorPicker avatarColorPicker;

    @FXML
    private Color avatarColor;

    @FXML
    Circle AVATAR;

    @FXML
    protected void setAvatarColor(ActionEvent event)
    {
        AVATAR.setFill(avatarColorPicker.getValue());
    }



}