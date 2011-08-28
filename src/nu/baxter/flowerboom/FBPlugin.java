package nu.baxter.flowerboom;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.plugin.java.JavaPlugin;
public class FBPlugin extends JavaPlugin {
    private class FBListener extends BlockListener {
        @Override
        public void onBlockBreak(BlockBreakEvent event) {
            if ((event.getBlock().getType().getId() == 37) || (event.getBlock().getType().getId() == 38)) {
                if (Math.random() > 0.8) {
                    event.getBlock().setTypeId(0);
                    event.getBlock().getWorld().createExplosion(event.getBlock().getLocation(), 4, true);
                }
            }
        }
    }
    @Override
    public void onDisable() {
        System.out.println("[FlowerBoom] Version " + this.getDescription().getVersion() + " disabled.");
    }
    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvent(BlockBreakEvent.Type.BLOCK_BREAK, new FBListener(), BlockBreakEvent.Priority.Normal, this);
        System.out.println("[FlowerBoom] Version " + this.getDescription().getVersion() + " enabled.");
    }
}