package ua.epam.workers_managers.controller.actions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dennis
 *
 * on 12/24/2015.
 */
public class ActionFactory {
    private final Map<String, Action> actions = new HashMap<>();
    private static ActionFactory INSTANCE;

    private ActionFactory() {
        actions.put("fire", new ActionFire());
        actions.put("hire", new ActionHire());
        actions.put("set_manager", new ActionSetManager());
        actions.put("set_worker", new ActionSetWorker());
        actions.put("set_other", new ActionSetOther());
        actions.put("attach_to_manager", new ActionAttachToManager());
        actions.put("detach_from_manager", new ActionDetachFromManager());
        actions.put("sort_by_name", new ActionSortByName());
        actions.put("sort_by_date", new ActionSortByDate());
        actions.put("exit", new ActionExit());
        actions.put("help", new ActionHelp());

    }

    public static ActionFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ActionFactory();
        }
        return INSTANCE;
    }

    public Action getAction(String key) {
        return actions.get(key);
    }
}
