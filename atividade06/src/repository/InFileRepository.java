package repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InFileRepository<T> implements CrudRepository<T> {
    private String filename;
    private Map<Integer, T> entities = new HashMap<>();
    private int nextId = 1;
    private Gson gson = new Gson();
    private Type entityType;


    public InFileRepository(String filename, Type entityType) {
        this.filename = filename;
        this.entityType = entityType;
        loadFromFile();
    }


    private void loadFromFile() {
        File file = new File(filename);
        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
                entities = new HashMap<>();
                nextId = 1;
            } catch (IOException e) {
                System.out.println("Erro ao criar arquivo");
            }
        } else {
            try (FileReader reader = new FileReader(filename)) {
                Type mapType = TypeToken.getParameterized(Map.class, Integer.class, entityType).getType();
                entities = gson.fromJson(reader, mapType);

                if(entities == null) {
                    entities = new HashMap<>();
                }

                nextId = entities.isEmpty() ? 1 : entities.keySet().stream().max(Integer::compareTo).get() + 1;

            } catch (IOException e) {
                System.out.println("Errqo ao ler arquivo");
            }
        }
    }

    private void saveToFile() {
        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(entities, writer);
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo");
        }
    }

    @Override
    public void save(T entity) {
        int id = (int) getId(entity);
        if (entities.containsKey(id)) {
            update(entity);
        } else {
            entities.put(id, entity);
            saveToFile();
        }
    }

    @Override
    public void update(T entity) {
        int id = (int) getId(entity);

        if(entities.containsKey(id)){
            entities.put(id, entity);
            saveToFile();
        }else{
            System.out.println("Entidade com ID " + id + " não encontrada para atualização.");
        }
    }

    @Override
    public void delete(T entity) {
        int id = (int) getId(entity);

        if(entities.containsKey(id)){
            entities.remove(id);
            saveToFile();
        }else{
            System.out.println("Entidade com ID " + id + " não encontrada para remoção.");
        }
    }


    @Override
    public T findById(int id) {
        if(entities.containsKey(id)){
            return entities.get(id);
        }
        System.out.println("Entidade com ID " + id + " não encontrada.");
        return null;
    }


    @Override
    public List<T> findAll() {
        return new ArrayList<>(entities.values());
    }


    // metodo privado que acessa o id da entidade usando reflexao
    private Object getId(T entity) {
        try {
            // acessa o metodo getId da entidade e o invoca
            Method getIdMethod = entity.getClass().getMethod("getId");
            return getIdMethod.invoke(entity);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao acessar ID da entidade.", e);
        }
    }

}
