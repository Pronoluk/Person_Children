package pl.pronoluk.parent_children.model;

public enum Sex {

    MALE('M'),
    FEMALE('F');

    public char hetSex() {
        return sex;
    }

    private final char sex;

    Sex(char sex) {
        this.sex = sex;
    }




}
