package entidades;

public class PessoaJuridica extends Contribuinte {
	
	private Integer funcionarios;

	public PessoaJuridica() {
		super();
	}

	public PessoaJuridica(String nome, Double rendaAnual, Integer funcionarios) {
		super(nome, rendaAnual);
		this.funcionarios = funcionarios;
	}


	public Integer getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Integer funcionarios) {
		this.funcionarios = funcionarios;
	}

	@Override
	public double calculaImposto() {
		if(funcionarios>10) {
			return rendaAnual*0.14;
		}else {
			return rendaAnual*0.16;
		}
		
	}

}
