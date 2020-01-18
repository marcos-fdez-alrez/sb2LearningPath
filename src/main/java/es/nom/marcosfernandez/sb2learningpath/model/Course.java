package es.nom.marcosfernandez.sb2learningpath.model;


import lombok.*;

//@Getter
//@Setter

@ToString(includeFieldNames=true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    private Long id;
    private String name;
    private Integer chapterCount;


}
