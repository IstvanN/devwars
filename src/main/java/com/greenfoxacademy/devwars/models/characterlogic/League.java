package com.greenfoxacademy.devwars.models.characterlogic;

public enum League {
    BACKEND {
        public String toString() {
            return "Backend";
        }
    },
    FRONTEND {
        public String toString() {
            return "Frontend";
        }
    },
    DEVOPS {
        public String toString() {
            return "DevOps";
        }
    },
    TESTER {
        public String toString() {
            return "Tester";
        }
    },
    DATA_SCIENTIST {
        public String toString() {
            return "Data Scientist";
        }
    },
    EMBEDDED {
        public String toString() {
            return "Embedded";
        }
    }

}
