package eg.edu.alexu.csd.oop.game.model;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.log4j.Logger;

import eg.edu.alexu.csd.oop.game.Strategy;
import eg.edu.alexu.csd.oop.game.controller.Main;


public class Dynamic {
	private static Logger log = Logger.getLogger(Dynamic.class);
	public List<Class<? extends Strategy>> getSupportedShapes() {
		// TODO Auto-generated method stub
		log.info("Load the shapes from jar");
		List<Class<? extends Strategy>> shapes = new ArrayList<Class<? extends Strategy>>();
		File pathToJar = new File(
				"D:\\game\\finalGame\\finalGame\\lib\\my_jar.jar");

		JarFile jarFile;
		try {
			jarFile = new JarFile(pathToJar);
			Enumeration<JarEntry> e = jarFile.entries();

			URL[] urls = { new URL("jar:file:" + pathToJar + "!/") };
			URLClassLoader cl = URLClassLoader.newInstance(urls);

			while (e.hasMoreElements()) {
				JarEntry je = e.nextElement();
				if (je.isDirectory() || !je.getName().endsWith(".class")) {
					continue;
				}
				// -6 because of .class
				String className = je.getName().substring(0, je.getName().length() - 6);
				className = className.replace('/', '.');
				try {
					
					Class c = cl.loadClass(className);
					shapes.add(c);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		log.info("Shapes are loaded successfully");
		return shapes;

	}

}
