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
package org.sdemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Dictionary;
import java.util.Scanner;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.annotations.Reference;

public class Activator implements BundleActivator {


	public void start(BundleContext context) throws Exception {
		System.out.println("Starting the bundle");
		
		Scanner sc = new Scanner(System.in);
		String con="";
		do {
			System.out.println("1.Insert 2.Display 3.Update 4.Delete");
			System.out.println("enter your choice:");
			int choice = sc.nextInt();
			System.out.println(choice);
			switch (choice) {
			case 1:
				Insertion.insert();
				break;
			case 2:
				Selection.select();
				break;
			case 3:
				Updation.update();
				break;
			case 4:
				Deletion.delete();
				break;
			}
			System.out.println("do you want to continue Y/N");
			con=sc.next();
		} while (con.equalsIgnoreCase("Y"));
	}

	public void stop(BundleContext context) {
		System.out.println("Stopping the bundle");
	}

}