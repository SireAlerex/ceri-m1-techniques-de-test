package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static fr.univavignon.pokedex.api.IPokemonFactoryTest.bulbizarre;
import static fr.univavignon.pokedex.api.IPokemonFactoryTest.aquali;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class IPokedexTest {
	static IPokedex pokedex;

	@BeforeAll
	static void setIPokedexTest() throws PokedexException {
		// pokedex = mock(IPokedex.class);

		// when(pokedex.size()).thenReturn(0).thenReturn(1);

		// when(pokedex.getPokemon(eq(-1))).thenThrow(PokedexException.class);
		// when(pokedex.getPokemon(eq(151))).thenThrow(PokedexException.class);

		// when(pokedex.addPokemon(bulbizarre)).thenReturn(bulbizarre.getIndex());
		// when(pokedex.getPokemon(bulbizarre.getIndex())).thenReturn(bulbizarre);

		// when(pokedex.addPokemon(aquali)).thenReturn(aquali.getIndex());
		// when(pokedex.getPokemon(aquali.getIndex())).thenReturn(aquali);

		// when(pokedex.getPokemons()).thenReturn(new ArrayList<>(List.of(bulbizarre, aquali)));
		// when(pokedex.getPokemons(PokemonComparators.INDEX)).thenReturn(new ArrayList<>(List.of(bulbizarre, aquali)));
		// when(pokedex.getPokemons(PokemonComparators.NAME)).thenReturn(new ArrayList<>(List.of(aquali, bulbizarre)));
		// when(pokedex.getPokemons(PokemonComparators.CP)).thenReturn(new ArrayList<>(List.of(aquali, bulbizarre)));
	
		pokedex = new Pokedex(new PokemonMetadataProvider(), new PokemonFactory());
	}

	@Test
	void sizeIncreaseAfterAddTest() {
		assertEquals(pokedex.size(), 0);
		pokedex.addPokemon(bulbizarre);
		assertEquals(pokedex.size(), 1);
	}

	@Test
	void throwExceptionWhenInvalidIndexTest() {
		assertThrows(PokedexException.class, () -> pokedex.getPokemon(-1));
		assertThrows(PokedexException.class, () -> pokedex.getPokemon(151));
	}

	@Test
	void canChainAddAndGetBulbizarre() throws PokedexException {
		int id = pokedex.addPokemon(bulbizarre);
		Pokemon result = pokedex.getPokemon(id);
		assertEquals(result, bulbizarre);
	}

	@Test
	void canChainAddAndGetAquali() throws PokedexException {
		int id = pokedex.addPokemon(aquali);
		Pokemon result = pokedex.getPokemon(id);
		assertEquals(result, aquali);
	}

	@Test
	void getPokemonsTest() {
		pokedex.addPokemon(bulbizarre);
		pokedex.addPokemon(aquali);

		List<Pokemon> list = new ArrayList<>(List.of(bulbizarre, aquali));
		assertEquals(pokedex.getPokemons(), list);
	}

	@Test
	void getPokemonsComparatorTest() {
		pokedex.addPokemon(bulbizarre);
		pokedex.addPokemon(aquali);

		List<Pokemon> listName = new ArrayList<>(List.of(aquali, bulbizarre));
		assertEquals(pokedex.getPokemons(PokemonComparators.NAME), listName);

		List<Pokemon> listIndex = new ArrayList<>(List.of(bulbizarre, aquali));
		assertEquals(pokedex.getPokemons(PokemonComparators.INDEX), listIndex);

		List<Pokemon> listCP = new ArrayList<>(List.of(bulbizarre, aquali));
		assertEquals(pokedex.getPokemons(PokemonComparators.CP), listCP);
	}
}
