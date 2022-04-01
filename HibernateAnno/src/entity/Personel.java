package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@ToString(exclude = { "bolum" })
@EqualsAndHashCode(exclude = { "bolum" })
public class Personel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 30)
	private String adi;
	@Column(name = "soyadi", length = 30)
	private String soyadi;
	@ManyToOne(fetch = FetchType.EAGER)
	private Bolum bolum;
}
