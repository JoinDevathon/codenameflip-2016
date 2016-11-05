package org.devathon.contest2016.backend.situation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class was created on 11/5/16 by @codenameflip
 * All code contained within this class is sole property of the author.
 **/

public enum SituationPriority {

    IRRELEVANT( new SituationAction[]{

    } ),
    MONITOR( new SituationAction[]{

    } ),
    POTENTIAL( new SituationAction[]{

    } ),
    HIGH( new SituationAction[]{

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
