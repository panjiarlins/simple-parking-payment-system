package finalexam;

public abstract class Jenis{
	public abstract void setPlat(String a);
	public abstract void setPlat(String a, int b);
	public abstract String getPlat();
	public abstract int getPrice();
	public abstract String getTime();
	
	public String toString() {
		return "Type: ";
	}
}