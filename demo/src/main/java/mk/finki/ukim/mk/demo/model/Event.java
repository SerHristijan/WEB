package mk.finki.ukim.mk.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "events")
public class Event {
    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private double popularityScore;
    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    protected Location location;

    // konsturktorot bez id, bodejki samo se generira so random
    public Event(String name, String description, double popularityScore, Location location) {
        this.id = (long) (Math.random() * 1000);  // generira random id
        this.name = name;
        this.description = description;
        this.popularityScore = popularityScore;
        this.location = location;
    }

}
