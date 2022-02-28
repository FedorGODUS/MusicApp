package Andersen.SeqDemo.music;

import Andersen.SeqDemo.entities.Audio;
import Andersen.SeqDemo.entities.Author;
import Andersen.SeqDemo.repo.AudioRepository;
import Andersen.SeqDemo.repo.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.applet.AudioClip;
import java.io.*;
import java.util.Arrays;
import java.util.Optional;

import static Andersen.SeqDemo.music.Sound.playSound;

@Service
public class Player {
    @Autowired
    private AudioRepository audioRepository;
    @Autowired
    private AuthorRepository authorRepository;
    public String addMusic(String audioReq, MultipartFile file) throws UnsupportedAudioFileException, IOException {
        Audio audio = new Audio();
        audio.setTitle(file.getOriginalFilename());
        Optional<Author> author = authorRepository.findAuthorByName(audioReq);
        author.ifPresent(audio::setAuthor);
        audio.setAudio(file.getInputStream().readAllBytes());
        audioRepository.save(audio);
        return audio.getTitle();
    }

    public void play(String name) throws IOException {
        Audio audio = new Audio();
        Optional<Audio> audioOptional = audioRepository.findAudioByTitle(name);
        if(audioOptional.isPresent()) audio = audioOptional.get();
        File file = new File(name="Audio");
        OutputStream outputStream = new FileOutputStream(file);
        outputStream.write(audio.getAudio());
        outputStream.close();
        Sound sound = new Sound(file.getAbsoluteFile());
        sound.play();
    }
}
