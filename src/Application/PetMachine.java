package Application;

public class PetMachine {
	
	
	private boolean clean = true;
	
	private int water = 30;
	
	private int shampoo = 10;
	
	private Pet pet = null;
	
	public void takeAShower() {
	    if (this.pet == null) {
	        System.out.println("Coloque o pet na máquina para iniciar o banho.");
	        return;
	    }
	    
	    if (this.water < 10 || this.shampoo < 2) {
	        System.out.println("Não há água ou shampoo suficiente para dar banho.");
	        return;
	    }

	    this.water -= 10;
	    this.shampoo -= 2;
	    
	    pet.setClean(true);
	    System.out.println("O pet " + pet.getName() + " está limpo!");
	}

	public void addWater() {
	    if (water >= 30) {
	        System.out.println("A capacidade de água da máquina está no máximo!");
	    } else {
	        water = Math.min(30, water + 2);
	        System.out.println("Água adicionada. Agora há " + water + " litros.");
	    }
	}

	public void addShampoo() {
	    if (shampoo >= 10) {
	        System.out.println("A capacidade de shampoo da máquina está no máximo!");
	    } else {
	        shampoo = Math.min(10, shampoo + 2);
	        System.out.println("Shampoo adicionado. Agora há " + shampoo + " litros.");
	    }
	}

	public int getWater() {
		return water;
	}


	public int getShampoo() {
		return shampoo;
	}

	
	public boolean hasPet() {
		return pet != null;
	}

	public void setPet(Pet pet) {
		if (!this.clean) {
			System.out.println("A máquina está suja. para colocar o pet é necessário limpá-la");
			return;
		}
		if (hasPet()) {
			System.out.println("O pet " + this.pet.getName() + " está na máquina nesse momento");
			return;
		}
		
		this.pet = pet;
	}
	
	public void removePet() {
	    if (pet == null) {
	        System.out.println("Não há pet na máquina para remover.");
	        return;
	    }
	    
	    this.clean = this.pet.isClean();	
	    System.out.println("O pet " + pet.getName() + " foi retirado da máquina" + (this.clean ? " e está limpo!" : " mas ainda está sujo."));
	    this.pet = null;
	}

	
	public void wash() {
		this.water -= 10;
		this.shampoo -= 2;
		this.clean = true;
		
		System.out.println("A máquina foi limpa");
	}
	
	
	
	
}
