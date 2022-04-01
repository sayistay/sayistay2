package tr.gov.sayistay.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NamedQuery(name = "kitapSayisi", query = "select count(k) from Kitap k")

@Entity
@Data
@ToString(exclude = "yazar")
@EqualsAndHashCode(exclude = "yazar")
@AllArgsConstructor
@NoArgsConstructor
public class Kitap implements Serializable {
	private static final long serialVersionUID = 7472174558809089749L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String adi;
	@Column(name = "sayfa_sayisi")
	private int sayfaSayisi;
	@ManyToOne
	private Yazar yazar;
}
