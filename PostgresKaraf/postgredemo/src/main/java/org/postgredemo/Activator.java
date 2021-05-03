/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.postgredemo;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    public void start(BundleContext context) throws Exception {
        System.out.println("Starting the bundle");
        
        
        Scanner sc=new Scanner(System.in);
        
		int choice=0;
		do {
			System.out.println("Select your option\n 1. Insert\n 2. Update\n 3. Display\n 4. Delete\n 5. Exit");
			choice=sc.nextInt();
			System.out.println(choice);
			if(choice == 1) {
				InsertLogic.insert();
			}else if(choice == 2) {
				UpdateLogic.update();
			}else if(choice == 3) {
				DisplayLogic.display();
			}else if(choice == 4) {
				DeleteLogic.delete();
			}
		}while(choice!=5);		
    }

    public void stop(BundleContext context) {
        System.out.println("Stopping the bundle");
    }

}