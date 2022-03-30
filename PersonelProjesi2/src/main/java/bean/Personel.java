package bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class Personel implements Serializable {
	private static final long serialVersionUID = 14385763429758326L;
	private int id;
	private String adi;
	private String soyadi;

}
