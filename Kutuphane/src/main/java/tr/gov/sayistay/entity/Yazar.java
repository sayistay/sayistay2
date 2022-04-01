package tr.gov.sayistay.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NamedQuery(name = "yazarSayisi", query = "select count(y) from Yazar y")
@NamedQuery(name = "getYazarByAdiSoyadi", query = "from Yazar y where y.adi = ?1 and y.soyadi = ?2")
@NamedQuery(name = "getTumYazarlar", query = "from Yazar")
@NamedQuery(name = "getYazarById", query = "from Yazar y where y.id = ?1")

@Entity
@Data
@ToString(exclude = "kitaplar")
@EqualsAndHashCode(exclude = "kitaplar")
@AllArgsConstructor
@NoArgsConstructor
public class Yazar implements Serializable {
	private static final long serialVersionUID = 6633850860136844838L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String adi;
	private String soyadi;
	@Column(name = "dogum_tarihi")
	private LocalDate dogumTarihi;
	@OneToMany(mappedBy = "yazar")
	private Set<Kitap> kitaplar;
}
