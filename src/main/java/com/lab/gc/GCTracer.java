package com.lab.gc;

import java.util.HashMap;
import java.util.Map;

public class GCTracer {

    static class UserSession {
        String token;
        UserSession(String token) { this.token = token; }
    }

    private static Map<String, UserSession> globalCache = new HashMap<>();

    public static void main(String[] args) {
        UserSession activeSession = new UserSession("SESS-101");
        UserSession temporarySession = new UserSession("SESS-202");

        globalCache.put("ACTIVE", activeSession);
        
        processSession(temporarySession);
        temporarySession = null;

        // POINT B: Execution reaches here
        System.gc(); // Explicit request to run GC (hint only)
    }

    private static void processSession(UserSession session) {
        UserSession internalSession = new UserSession("SESS-303");
        session = internalSession;
    }
}