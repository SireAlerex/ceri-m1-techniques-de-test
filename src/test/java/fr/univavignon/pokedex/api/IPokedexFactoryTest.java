package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class IPokedexFactoryTest {
	static IPokedexFactory pokedexFactory;

	@BeforeAll
	static void setPokedexFactory() {
		// pokedexFactory = mock(IPokedexFactory.class);

		// when(pokedexFactory.createPokedex(any(), any())).thenReturn(mock(IPokedex.class));
		pokedexFactory = new PokedexFactory();
	}

	@Test
	void returnNotNullTest() {
		IPokedex pokedex = pokedexFactory.createPokedex(mock(IPokemonMetadataProvider.class), mock(IPokemonFactory.class));
		assertNotNull(pokedex);
	}
}
