package com.revature;

import com.revature.daos.AnimalsDAO;
import com.revature.daos.UsersDAO;
import com.revature.models.Animals;
import com.revature.models.Users;


             //--in Postman: go to url http://localhost:8080/PetShop/populate with the POST method , check your database --//


public class Populate {
	public void please() {
		
		
		
		UsersDAO uDAO = new UsersDAO();
		AnimalsDAO aDAO = new AnimalsDAO();
		
		
		//user
		Users newUser = new Users("myUsername","password",false,"myFirst","myLast","myMail@mail.com",false,null);
		System.out.println(newUser.toString());
		uDAO.newUser(newUser);
		
		//Dogs
		Animals d1 = new Animals("CHARLIE","dog","pug","12","M","small",600,"https://vetstreet.brightspotcdn.com/dims4/default/65bbc05/2147483647/thumbnail/645x380/quality/90/?url=https%3A%2F%2Fvetstreet-brightspot.s3.amazonaws.com%2Fc1%2Ff9%2F13fe778446f1b8a4fcbe7146e4a4%2FAP-TVQEZK-ph645080113.jpg");
		Animals d2 = new Animals("BAILEY","dog","pug","9","M","small",400,"https://i1.wp.com/nen.press/wp-content/uploads/2020/01/Peaches-the-Pug.png");
		Animals d3 = new Animals("MILO","dog","Rottweiler","10","F","large",450,"https://d2725vydq9j3xi.cloudfront.net/production/media/lawyer_ohara/images/ISS_0908_00279.0daf1c35.fill-847x400.jpg");
		Animals d4 = new Animals("RUDY","dog","Rottweiler","3","M","medium",350,"https://emeraldagro.com.ng/wp-content/uploads/2020/08/two-rottweiler-1.jpg");
		Animals d5 = new Animals("WALTER","dog","Rottweiler","2","M","small",800,"https://www.dogbreedslist.info/uploads/dog-pictures/rottweiler-2.jpg");
		Animals d6 = new Animals("CHIP","dog","Husky","7","F","small",650,"https://a-z-animals.com/media/siberian-husky-1.jpg");
		Animals d7 = new Animals("MAX","dog","Husky","9","F","medium",700,"https://www.metrovetchicago.com/sites/default/files/styles/large/public/siberian-husky-dog-breed-info.jpg?itok=m9gSUDq7");
		aDAO.newAnimal(d1);
		aDAO.newAnimal(d2);
		aDAO.newAnimal(d3);
		aDAO.newAnimal(d4);
		aDAO.newAnimal(d5);
		aDAO.newAnimal(d6);
		aDAO.newAnimal(d7);
		
		//cats
		Animals c1 = new Animals("Chloe","cat","Persian","12","F","small",200,"https://vetstreet.brightspotcdn.com/dims4/default/5c40e17/2147483647/thumbnail/645x380/quality/90/?url=https%3A%2F%2Fvetstreet-brightspot.s3.amazonaws.com%2F51%2F45%2Fa7f47de448fabce6e4a908cb878d%2FPersian-AP-J6XREO-645sm3614.jpg");
		Animals c2 = new Animals("Nala","cat","Persian","9","F","small",150,"https://www.thesprucepets.com/thmb/jlnwXBRNbPIWmIBLlXTkHfGtkro=/1299x1299/smart/filters:no_upscale()/GreyPersianCatonGreenRug-67bef10b503d4e27b8264bc09f32983c.jpg");
		Animals c3 = new Animals("Zelda","cat","Scottish Fold","10","F","large",300,"https://www.pumpkin.care/cat-breeds/wp-content/uploads/2021/03/Scottish-Fold-Hero-1200x628.png");
		Animals c4 = new Animals("Jack","cat","Scottish Fold","3","M","medium",275,"https://www.rover.com/blog/wp-content/uploads/2019/08/scottish-fold-white-683x1024.jpg");
		Animals c5 = new Animals("Luna","cat","Ragdoll","2","M","small",450,"https://s36537.pcdn.co/wp-content/uploads/2018/01/Ragdoll-cat-on-blue-backdrop-.jpg.optimal.jpg");
		Animals c6 = new Animals("Maya","cat","Ragdoll","7","F","small",400,"https://cdn.shopify.com/s/files/1/1088/7528/articles/6670edd5ab4bbc9e61a335bea85b2004_1600x.jpg?v=1579075442");
		Animals c7 = new Animals("Rita","cat","Ragdoll","9","F","medium",350,"https://vetstreet.brightspotcdn.com/dims4/default/0a0f878/2147483647/crop/695x409%2B0%2B17/resize/645x380/quality/90/?url=https%3A%2F%2Fvetstreet-brightspot.s3.amazonaws.com%2F6b%2Fce%2Fc975360d4695ab67586cc9a93880%2Fragdoll-ap-zqsits.jpg");
		aDAO.newAnimal(c1);
		aDAO.newAnimal(c2);
		aDAO.newAnimal(c3);
		aDAO.newAnimal(c4);
		aDAO.newAnimal(c5);
		aDAO.newAnimal(c6);
		aDAO.newAnimal(c7);
		
		//fish
		Animals f1 = new Animals("Bait","fish","Goldfish","1","F","small",200,"https://i.guim.co.uk/img/media/9c03bd43c119834ece958f3c370dec83146fe04a/0_200_6000_3602/master/6000.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=de1abf11d1a7a961d5fea63f5a8bee55");
		Animals f2 = new Animals("Alpha","fish","Goldfish","2","F","small",150,"https://www.thesprucepets.com/thmb/T58xQ4v2aPSgf8yHflUPhG-LnzM=/1885x1414/smart/filters:no_upscale()/GettyImages-1214858342-830a0f19ba764412a44e024b9877a5cf.jpg");
		Animals f3 = new Animals("Marlin","fish","Goldfish Fold","2","F","large",300,"https://www.peta.org.uk/wp-content/uploads/2018/08/gold-1022229_1920.jpg");
		Animals f4 = new Animals("Nemo","fish","Neon tetra","3","M","medium",275,"https://www.thesprucepets.com/thmb/BTUpTekiPP6YvaJB0IKLMJG0GkA=/2486x2486/smart/filters:no_upscale()/neon-tetra-paracheirodon-1381835-hero-2cc17d27c90d4215bfe4deeeab03e0a5.jpg");
		Animals f5 = new Animals("Leviathan","fish","Neon tetra","2","M","small",450,"https://media-be.chewy.com/wp-content/uploads/2019/10/22104716/Cardinal-and-neon-tetras.jpg");
		Animals f6 = new Animals("Poseidon","fish","Zebrafish","5","F","small",400,"https://www.brainfacts.org/-/media/Brainfacts2/In-the-Lab/Animals-in-Research/zebrafish-image-thumbnail.jpg");
		Animals f7 = new Animals("Fin","fish","Zebrafish","2","F","medium",350,"https://dc.medill.northwestern.edu/wp-content/uploads/2019/04/fish-before--1080x675.jpg");
		aDAO.newAnimal(f1);
		aDAO.newAnimal(f2);
		aDAO.newAnimal(f3);
		aDAO.newAnimal(f4);
		aDAO.newAnimal(f5);
		aDAO.newAnimal(f6);
		aDAO.newAnimal(f7);
		
		
		
		
	}
}
