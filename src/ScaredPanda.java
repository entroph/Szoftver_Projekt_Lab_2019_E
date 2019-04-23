/**
 * Ijedős panda osztálya, reagál a Scare függvényre
 */
public class ScaredPanda extends Panda{

    public ScaredPanda(String name, Field field){
        super(name, field);
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
    }

    /**
     * ToString override.
     * @return
     */
    @Override
    public String toString(){
        return "ScaredPanda";
    }
}