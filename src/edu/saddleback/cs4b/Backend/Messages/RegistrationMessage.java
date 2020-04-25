package edu.saddleback.cs4b.Backend.Messages;

import edu.saddleback.cs4b.Backend.Utilitys.Profile;

public class RegistrationMessage extends BaseMessage
{
    private Profile profile;

    public RegistrationMessage() {
        this(null);
    }

    public RegistrationMessage(Profile newProfile) {
        super(MsgTypes.REGISTRATION);
        setProfile(newProfile);
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    // todo should this be immutable?
    public Profile getProfile() { return profile; }
}
