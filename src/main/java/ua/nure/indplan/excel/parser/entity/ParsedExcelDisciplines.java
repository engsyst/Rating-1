package ua.nure.indplan.excel.parser.entity;

public class ParsedExcelDisciplines extends EntityWithHours {

    private DisciplineHolder autumn;
    private DisciplineHolder spring;

    public ParsedExcelDisciplines(DisciplineHolder autumn, DisciplineHolder spring) {
        this.autumn = autumn;
        this.spring = spring;
    }

    @Override
    public String toString() {
        return "ParsedExcelDisciplines{" +
               "autumn=" + autumn +
               ", spring=" + spring +
               '}';
    }

    public DisciplineHolder getAutumn() {
        return autumn;
    }

    public ParsedExcelDisciplines setAutumn(DisciplineHolder autumn) {
        this.autumn = autumn;
        return this;
    }

    public DisciplineHolder getSpring() {
        return spring;
    }

    public ParsedExcelDisciplines setSpring(DisciplineHolder spring) {
        this.spring = spring;
        return this;
    }

    //TODO: Check, do we need retrieve year, teacher, percent and other data from excel document.
}
