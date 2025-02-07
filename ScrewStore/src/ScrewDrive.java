public enum ScrewDrive {
    SlotDrive {
        @Override
        public String toString() {
            return "schlitz";
        }
    },
    Cross {
        @Override
        public String toString() {
            return "kreuzschlitz";
        }
    },
    Hex {
        @Override
        public String toString() {
            return "sechskant";
        }
    },
    Torx {
        @Override
        public String toString() {
            return "Torx";
        }
    },
    Circle {
        @Override
        public String toString() {
            return "წრე";
        }
    };

    @Override
    public abstract String toString();
}

