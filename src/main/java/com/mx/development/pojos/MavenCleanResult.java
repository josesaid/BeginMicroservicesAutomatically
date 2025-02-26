package com.mx.development.pojos;

import com.mx.development.MAVEN_GOALS;
import lombok.Data;

@Data
public class MavenCleanResult extends BaseResult{
    private MAVEN_GOALS goal = MAVEN_GOALS.CLEAN;

    public MavenCleanResult(){
        setGoal(MAVEN_GOALS.CLEAN);
    }

}
