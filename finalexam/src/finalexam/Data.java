package finalexam;

public class Data {
	Jenis mobil = new Mobil(5000);
	Jenis motor = new Motor(2000);
	public int price;
	public String type, time, plat;
	public Data(String a, int num) {
		if(num == 1) {
			this.mobil.setPlat(a);
			this.plat = this.mobil.getPlat();
			this.time = this.mobil.getTime();
			this.price = this.mobil.getPrice();
			this.type = this.mobil.toString();
		}else {
			this.motor.setPlat(a);
			this.plat = this.motor.getPlat();
			this.time = this.motor.getTime();
			this.price = this.motor.getPrice();
			this.type = this.motor.toString();
		}
	}
}