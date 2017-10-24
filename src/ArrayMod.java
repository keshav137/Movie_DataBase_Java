
public class ArrayMod {
	String[] arrayAct = new String[0];
	public int size = 0;
	
	public String[] add(String element){
		String[] newArray = new String[arrayAct.length  + 1];
		for (int i = 0; i < arrayAct.length; i ++){
			newArray[i] = arrayAct[i];
			this.size ++;
		}
		newArray[arrayAct.length] = element;
		this.size++;
		arrayAct = newArray;
		return arrayAct;
	}
	
	public String ArrayModString(){
		String result = "";
		for(int i = 0; i < arrayAct.length - 1; i ++){
			result += arrayAct[i] + ", ";
		}
		result += arrayAct[arrayAct.length - 1] + ".";
		return result;
	}	
	public ArrayMod copyFromArray(String[] array){
		for(int i = 0; i < array.length; i ++){
			this.add(array[i]);
		}
		return this;
	}
	public void print(){
		for(int i = 0; i < arrayAct.length; i ++){
			System.out.println(arrayAct[i]);
		}
	}
}
