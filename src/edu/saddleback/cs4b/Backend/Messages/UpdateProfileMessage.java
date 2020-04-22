package edu.saddleback.cs4b.Backend.Messages;

import edu.saddleback.cs4b.Backend.Utilitys.Profile;

public class UpdateProfileMessage extends BaseMessage {
    private Profile profile;


    UpdateProfileMessage() {
        this(null);
    }

    public UpdateProfileMessage(Profile profile) {
        super(MsgTypes.UPDATE_PROFILE);
        setProfile(profile);
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    // todo should this be immutable?
    public Profile getProfile() { return profile; }
}
