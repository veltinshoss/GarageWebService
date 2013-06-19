/**
 * Copyright 2013 Ryan Shaw (ryanfx1@gmail.com)

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package com.blogspot.ryanfx.garage;

/**
 * I used this class for testing purposes until I got the raspberry pi
 * to function exactly as I wanted.
 * @author ryan
 *
 */
public class GarageDoorMemory implements GarageControl{

	private static GarageDoorMemory instance;
	private GarageDoorMemory(){}
	
	public static GarageDoorMemory getInstance(){
		if (instance == null){
			instance = new GarageDoorMemory();
		}
		return instance;
	}
	
	private boolean open;
	
	@Override
	synchronized public void toggleDoor() {
		open = !open;
	}


	@Override
	public boolean isClosed() {
		return !open;
	}


	@Override
	public boolean isOpen() {
		return open;
	}

	@Override
	public boolean closeDoor() {
		if (isOpen()){
			toggleDoor();
			return true;
		}
		return false;
	}

}