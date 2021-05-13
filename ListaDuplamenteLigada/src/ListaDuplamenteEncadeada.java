public class ListaDuplamenteEncadeada {
	private NO inicio;

	public ListaDuplamenteEncadeada() {
		inicio=null;
	}

	public void AdicionaInicio(int e){
		NO n=new NO(e);
		if (inicio!=null){
			n.prox=inicio;
			inicio.anterior=n;
		}
		inicio=n;
	}

	public void AdicionaFinal(int e){
		NO n=new NO(e);
		if (inicio==null){
			inicio=n;
			n.anterior=null;
			n.prox=null;
		}
		else{
			NO aux=inicio;
			while(aux.prox!=null){
				aux=aux.prox;
			}
			aux.prox=n;
			n.anterior=aux;
			n.prox=null;
		}
	}


	public int RemoveInicio(){
		int r=-1;
		if (inicio==null){
			System.out.println("Lista vázia");
		}
		else{
			r=inicio.dado;
			inicio=inicio.prox;
			if (inicio!=null){
				inicio.anterior=null;
			}
		}
		return r;
	}

	public int RemoveFinal(){
		int r=-1;
		if (inicio==null){
			System.out.println("Lista vázia");
		}
		else
			if (inicio.prox==null){
				r=inicio.dado;
				inicio=null;
			}
			else{
				NO aux1=inicio;
				NO aux2=inicio;
				while(aux1.prox!=null){
					aux2=aux1;
					aux1=aux1.prox;
				}
				r=aux1.dado;
				aux1.anterior=null;
				aux2.prox=null;
			}
		return r;
	}

	public String percorre(){
		String r=" ";
		NO aux=inicio;
		while(aux!=null){
			r=r+"\n"+aux.dado;
			aux=aux.prox;
		}
		return r;
	}
}

