package org.devathon.contest2016.backend.situation;

import org.devathon.contest2016.backend.situation.actions.Airstrike;
import org.devathon.contest2016.backend.situation.actions.ContactAssets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class was created on 11/5/16 by @codenameflip
 * All code contained within this class is sole property of the author.
 **/

public enum SituationPriority {

    IRRELEVANT( new SituationAction[]{
            new ContactAssets()
    } ),
    MONITOR( new SituationAction[]{
            new ContactAssets()
    } ),
    POTENTIAL( new SituationAction[]{
            new ContactAssets()
    } ),
    HIGH( new SituationAction[]{
            new ContactAssets(),
            new Airstrike()
    } )
    ;

    private SituationAction[] actions;

    SituationPriority(SituationAction[] actions) {
        this.actions = actions;
    }

    public SituationAction[] getActions() {
        return actions;
    }

    public List<SituationAction> getListActions() {
        List<SituationAction> possibleActions = new ArrayList<>();
        Collections.addAll(possibleActions, getActions());

        return possibleActions;
    }
}
