package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ToStringBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class IPokemonMetadataProviderTest {
	static IPokemonMetadataProvider pokemonMetadataProvider;
	static PokemonMetadata bulbizarreMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
	static PokemonMetadata aqualiMetadata = new PokemonMetadata(133, "Aquali", 186, 168, 260);

	@BeforeAll
	static void setupPokemonMetadataProvider() throws PokedexException {
		// pokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
		// when(pokemonMetadataProvider.getPokemonMetadata(anyInt())).thenAnswer( input -> {
		// 		int index = input.getArgument(0);
		// 		if (index == 0) return bulbizarreMetadata;
		// 		else if (index == 133) return aqualiMetadata;
		// 		else if (index < 0 || index > 150) {
		// 			throw new PokedexException("Invalid index");
		// 		} else {
		// 			return mock(PokemonMetadata.class);
		// 		}
		// });
		pokemonMetadataProvider = new PokemonMetadataProvider();
	}

	@Test
	void testInvalidIndex() {
		assertThrows(PokedexException.class, () -> pokemonMetadataProvider.getPokemonMetadata(-1));
		assertThrows(PokedexException.class, () -> pokemonMetadataProvider.getPokemonMetadata(151));
	}

	@Test
	void testBulbizarre() throws PokedexException {
		assert(pokemonMetadataProvider.getPokemonMetadata(0).equalsMetadata(bulbizarreMetadata));
	}

	@Test
	void testAquali() throws PokedexException {
		assert(pokemonMetadataProvider.getPokemonMetadata(133).equalsMetadata(aqualiMetadata));
	}
}
