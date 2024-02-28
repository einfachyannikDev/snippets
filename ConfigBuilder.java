package de.voxcraft.skywarssystem.utils;

import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Config {

    @Getter
    private FileConfiguration fileConfiguration;
    @Getter
    private File file;

    public Config(String name , File path){
        file = new File(path, name);

        if(!file.exists()){
            path.mkdir();
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        fileConfiguration = new YamlConfiguration();
        try {
            fileConfiguration.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }

    }

    public void save(){
        try {
            fileConfiguration.save(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void reload(){
        try {
            fileConfiguration.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    public File getFile() {
        return file;
    }

    public FileConfiguration getFileConfiguration() {
        return fileConfiguration;
    }

    public void set(String path, Object value){
        fileConfiguration.set(path, value);
    }

    public String getString(String path){
        return fileConfiguration.getString(path);
    }

    public List<String> getStringList(String path){
        return fileConfiguration.getStringList(path);
    }

    public List<?> getList(String path){
        return fileConfiguration.getList(path);
    }

    public boolean getBoolen(String path){
        return fileConfiguration.getBoolean(path);
    }

    public int getInt(String path){
        return fileConfiguration.getInt(path);
    }

    public double getDouble(String path){
        return fileConfiguration.getDouble(path);
    }

    public long getLong(String path){
        return fileConfiguration.getLong(path);
    }

    public ItemStack getItemStack(String path){
        return fileConfiguration.getItemStack(path);
    }

    public Location getLocation(String path){
        return fileConfiguration.getLocation(path);
    }

}
