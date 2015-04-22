package sub_mod.obj_block;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class RenderTileEntityObj extends TileEntitySpecialRenderer {

	public static final IModelCustom model = 
			AdvancedModelLoader.loadModel(new ResourceLocation(ModBlockObj.MODID, "obj/block.obj"));
	public static final ResourceLocation texture = new ResourceLocation(ModBlockObj.MODID, "textures/blocks/model_obj.png");

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f) {
		render((TileEntityObj)tile, x, y, z, f);
	}

	private void render(TileEntityObj tile, double x, double y, double z, float f) {
		GL11.glPushMatrix();
		GL11.glTranslated(x, y, z);
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);
		bindTexture(texture);
		model.renderAll();
		GL11.glPopMatrix();
	}

}
