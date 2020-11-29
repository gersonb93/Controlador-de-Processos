package entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "tb_processo")        
public class Processo  {

    

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idprocesso;

	
    private String numero_pub;
	
	
	private String numero_ped;
    
	
	private String datapubli;

	
	private String requerentes;
	
	
	private String titulo;
	

	public Processo() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Processo(Integer idprocesso, String numero_pub, String numero_ped, 
			String datapubli, String requerentes,
			String titulo) {
		super();
		this.idprocesso = idprocesso;
		this.numero_pub = numero_pub;
		this.numero_ped = numero_ped;
		this.datapubli = datapubli;
		this.requerentes = requerentes;
		this.titulo = titulo;
	}





	@Override
	public String toString() {
		return "Processo [idprocesso=" + idprocesso + ", numero_pub=" + numero_pub + ", numero_ped=" + numero_ped
				+ ", datapubli=" + datapubli + ", requerentes=" + requerentes + ", titulo=" + titulo + "]";
	}


	public Integer getIdprocesso() {
		return idprocesso;
	}


	public void setIdprocesso(Integer idprocesso) {
		this.idprocesso = idprocesso;
	}


	public String getNumero_pub() {
		return numero_pub;
	}


	public void setNumero_pub(String numero_pub) {
		this.numero_pub = numero_pub;
	}


	public String getNumero_ped() {
		return numero_ped;
	}


	public void setNumero_ped(String numero_ped) {
		this.numero_ped = numero_ped;
	}


	public String getdatapubli() {
		return datapubli;
	}


	public void setdatapubli(String datapubli) {
		this.datapubli = datapubli;
	}


	public String getRequerentes() {
		return requerentes;
	}


	public void setRequerentes(String requerentes) {
		this.requerentes = requerentes;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	

	
}