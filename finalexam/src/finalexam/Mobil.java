package finalexam;

public class Mobil extends Jenis{
	private String plat, time;
	private int price;
	
	public Mobil(int p) {
		Time obj = new Time();
		this.time = obj.getTime();
		this.price = p;
	}
	@Override
	public void setPlat(String a) {
		this.plat = a;
	}
	@Override
	public void setPlat(String a, int b) {
		this.plat = a;
		this.price = b;
	}
	@Override
	public String getPlat() {
		return plat;
	}
	@Override
	public int getPrice() {
		return price;
	}
	@Override
	public String getTime() {
		return time;
	}
	public String toString() {
		return "Car";
	}
	
}