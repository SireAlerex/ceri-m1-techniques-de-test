package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class IPokemonTrainerFactoryTest {
	static IPokemonTrainerFactory pokemonTrainerFactory;

	@BeforeAll
	static void setPokemonTrainerFactory() {
		// pokemonTrainerFactory = mock(IPokemonTrainerFactory.class);

		// when(pokemonTrainerFactory.createTrainer(anyString(), any(), any())).thenReturn(mock(PokemonTrainer.class));
	
		pokemonTrainerFactory = new PokemonTrainerFactory();
	}

	@Test
	void returnNotNullTest() {
		PokemonTrainer trainer = pokemonTrainerFactory.createTrainer("Sacha", Team.VALOR, mock(IPokedexFactory.class));
		assertNotNull(trainer);
	}
}
