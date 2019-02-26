package casino;

public class JugadorRojoNegro extends Jugador {

	protected boolean jugamosARojo;
	
	public JugadorRojoNegro(long saldoInicial, Banca b) {
		super(saldoInicial, b);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void hacerApuesta() {
		if (!banca.aceptaApuestas()) return ;
		if (apuestaRealizada) return ;
		/* Elegimos una apuesta...*/
		if (generador.nextBoolean()==true){
			System.out.println(nombreHilo+" elige apostar a rojo");
			jugamosARojo=true;
		} else {
			System.out.println(nombreHilo+" elige apostar a negro");
			jugamosARojo=false;
		}
		banca.sumarSaldo(5);
		restarSaldo(5);
		apuestaRealizada=true;
		/* Y pedimos a la banca que nos la acepte*/
		banca.aceptarApuesta(this);
	}

	public boolean esGanador(boolean rojo) {
		/* Este jugador necesita comprobar si ha salido el 0,
		 * aunque no lo elige nunca, ya que si hemos apostado
		 * Par podríamos pensar que hemos ganado cuando no es así */
		
			if (rojo && jugamosARojo)
			{
				return true;
			}
			if (!rojo  && !jugamosARojo)
			{
				return true;
			}
		 //Fin del else externo
		return false;
	//Fin de esGanador
	}

	@Override
	public void comunicarNumero(int numero) {
		boolean rojo;
		
		if (numero % 2 == 0) {
			rojo = true;
		} else {
			rojo = false;
		}
		
		if ( esGanador(rojo) ) {
			/*Ganamos y cogemos a la banca 20 euros*/
			System.out.println(nombreHilo + " gana 10 euros por acertar impar");
			banca.restarSaldo(10);
			this.sumarSaldo(10);
		}
		System.out.println(nombreHilo + " se queda con un saldo de "+saldo);
		/* Sea como sea, al terminar indicamos que ya no tenemos
		 * una apuesta realizada. Es decir, permitirmos al
		 * jugador volver a apostar	 */
		apuestaRealizada=false;
	}

}
