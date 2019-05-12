/**
 * Ijedős panda osztálya, reagál a Scare függvényre
 */
public class ScaredPanda extends Panda{

    public ScaredPanda(Field field){
        super(field);
    }

    /**
     * Nulláza a mögötte sorban állók following-ját.
     */
    public void scare() {
        Panda follower = (Panda) this.getFollower();
        while(follower != null){
            follower.setFollowing(null);
            follower = (Panda) follower.getFollower();
        }
        if (this.getFollower() != null)
            deleteFollower(this);
    }

    private void deleteFollower(Panda p){
        if (p.getFollower() != null){
            deleteFollower((Panda) p.getFollower());
        }
        if (p.getFollower() == null){
            follower = null;
            return;
        }

    }

    /**
     * ToString override.
     * @return
     */
    @Override
    public String toString(){
        return "scaredpanda";
    }
}