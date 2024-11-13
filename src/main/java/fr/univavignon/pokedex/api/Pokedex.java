package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex {
    IPokemonMetadataProvider pokemonMetadataProvider;
    IPokemonFactory pokemonFactory;
    Pokemon[] pokemons;
    int size;

    public Pokedex(IPokemonMetadataProvider pokemonMetadataProvider, IPokemonFactory pokemonFactory) {
        this.pokemonMetadataProvider = pokemonMetadataProvider;
        this.pokemonFactory = pokemonFactory;
        this.pokemons = new Pokemon[151];
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return pokemonMetadataProvider.getPokemonMetadata(index);
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        if (pokemons[pokemon.getIndex()] == null) {
            pokemons[pokemon.getIndex()] = pokemon;
            size++;
        }

        return pokemon.getIndex();
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        if (id < 0 || id > 150) throw new PokedexException("Invalid index ("+id+") must be 0..150");
        return pokemons[id];
    }

    @Override
    public List<Pokemon> getPokemons() {
        ArrayList<Pokemon> list = new ArrayList<>();
        for (Pokemon pokemon : pokemons) {
            if (pokemon != null) {
                list.add(pokemon);
            }
        }
        return list;
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> list = getPokemons();
        list.sort(order);
        return list;
    }
    
}
