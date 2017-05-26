package ua.nure.indplan.exeptions;

public class ExcelDocException extends Exception{

	private static final long serialVersionUID = 6362797497730424058L;
	int row;
	int column;

	public ExcelDocException(){	
	}
	
	public ExcelDocException(String arg0){
		super(arg0);
	}
	
	public ExcelDocException(Throwable arg0){
		super(arg0);
	}
	
	public ExcelDocException(String arg0, Throwable arg1){
		super(arg0, arg1);
	}
	
	public ExcelDocException(String arg0, Throwable arg1, boolean arg2, boolean arg3){
		super(arg0, arg1, arg2, arg3);
	}
	
	public int getRow(){
		return row;
	}
	
	public int getColumn(){
		return column;
	}
	
	public void setRow(int row){
		 this.row = row;
	}
	
	public void setColumn(int column){
		 this.column = column;
	}
}
