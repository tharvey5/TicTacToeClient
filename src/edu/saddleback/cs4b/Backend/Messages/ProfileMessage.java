package edu.saddleback.cs4b.Backend.Messages;

import edu.saddleback.cs4b.Backend.Utilitys.Profile;

/**
 * This is sent by the client when 1). They are registering a new profile or
 * 2). When they are updating existing details - this message is never to be
 * received by the client
 */
public class ProfileMessage extends BaseMessage {
    private Profile profile;

    /**
     * only to be used by the message factory
     */
    ProfileMessage() {
        this(null);
    }

    public ProfileMessage(Profile profile) {
        super(MsgTypes.PROFILE);
        setProfile(profile);
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    // todo should this be immutable?
    public Profile getProfile() { return profile; }
}
