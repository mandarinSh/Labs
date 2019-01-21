


class InputExcept extends Exception {
    private int detail;

    InputExcept(int detail) {
        this.detail = detail;
    }

    public String toString() {
        switch (this.detail) {
            case 0: {
                return "Invalid input args";
            }
            case 1: {
                return "Invalid input args. Found negative.";
            }
            default: {
                return "Something went wrong";
            }
        }
    }
}
