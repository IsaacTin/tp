package com.eva.ui;


import java.util.logging.Logger;

import com.eva.commons.core.LogsCenter;
import com.eva.model.person.applicant.Applicant;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;

/**
 * Panel containing the list of applicant.
 */
public class ApplicantListPanel extends UiPart<Region> {
    private static final String FXML = "ApplicantListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(ApplicantListPanel.class);

    @FXML
    private ListView<Applicant> applicantListView;

    /**
     * Creates a {@code ApplicantListPanel} with the given {@code ObservableList}.
     */
    public ApplicantListPanel(ObservableList<Applicant> applicantList) {
        super(FXML);
        applicantListView.setItems(applicantList);
        applicantListView.setCellFactory(listView -> new ApplicantListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Applicant} using a {@code ApplicantCard}.
     */
    class ApplicantListViewCell extends ListCell<Applicant> {
        @Override
        protected void updateItem(Applicant applicant, boolean empty) {
            super.updateItem(applicant, empty);

            if (empty || applicant == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new ApplicantListCard(applicant, getIndex() + 1).getRoot());
            }
        }
    }

}

