package graph_tp1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class AbstractListGraph <V> {

		//La liste est de type HashMap
		protected HashMap liste = new HashMap<>();
		protected List<V> marked = new ArrayList<V>();
		protected Set<V> verticesList = new HashSet<V>();
		
		public boolean addEdge(V fromVertex, V toVertex) {
			// TODO Auto-generated method stub
			Set<V> listTempo = new HashSet<V>();
			listTempo.add(toVertex);
			if(liste.containsKey(fromVertex)) {
				listTempo.addAll((Collection<? extends V>) liste.get(fromVertex));
			}
			this.liste.put(fromVertex, listTempo);
			
			if(this.getDotType()=="undigraph") {
				listTempo = new HashSet<V>();
				listTempo.add(fromVertex);
				if(liste.containsKey(toVertex)) {
					listTempo.addAll((Collection<? extends V>) liste.get(toVertex));
				}
				this.liste.put(toVertex, listTempo);
			}
			return false;
		}

		public boolean addVertex(V vertex) {
			// TODO Auto-generated method stub
			Set<V> listTempo = new HashSet<V>();
			this.liste.put(vertex, listTempo);
			return false;
		}

		public Set<V> getChildren(V vertex) {
			// TODO Auto-generated method stub
			return (Set<V>) this.liste.get(vertex);
		}
		
		public String printGraph() {
			StringBuilder s = new StringBuilder();
			s.append("digraph G { \n");
			Map<V, Set<V>> newListe = new HashMap<>();
			if(this.getDotType()=="digraph") newListe = liste;
			else newListe = getUniqueAdjacencies();
			
			for(Object key : newListe.keySet()) {
				V k = ((V)key);
				s.append("node [label="+k+"] "+key.hashCode()+"\n");
			}
			s.append("\n");
			for(Object key : newListe.keySet()){
				newListe.get(key);
				Set<V> listTempo = new HashSet<V>();
				listTempo = (Set<V>) newListe.get(key);
				
				for (V vertex : listTempo) {
					String node;
					if(this.getDotType() == "digraph") node = ((V)key)+" -> "+vertex;
					else if(this.getDotType() == "wegraph") node = ((V)key)+" -- "+vertex+ " [label="+ this.toString() +"]";
					else node = ((V)key)+" -- "+vertex;
					s.append(node + " \n");
			    }

			}
			s.append("}");
			return s.toString();
		}
		
		public <V> List<V> execute(Graph graph, V vertex) {
			Set<V> v1 = new HashSet();
			v1 = (Set<V>) graph.getChildren((V) vertex);
			
			List<V> myList = new ArrayList<V>();
			myList.add(vertex);
			setVertexMarked(vertex);
			
			if (v1 !=null) {
				for(V point:v1) {
					if(!marked.contains(point)) myList.addAll(execute(graph,point));
				}
			}
			return myList;
		}
		

		private void setVertexMarked(Object vertex) {
			this.marked.add((V)vertex);
		}
		
		public String listToString(List<V> list) {
			StringBuilder s = new StringBuilder();
			for (V vertex : list) {
				V node = vertex;
				s.append(node + " ");
			}
			return s.toString();
		}
		
		protected abstract String getDotType () ;
		
		protected Map<V,Set<V>> getUniqueAdjacencies() {
			Map<V, Set<V>> returnListe = new HashMap<>();
			Map<V, Set<V>> markedListe = new HashMap<>();
			
			for(Object key : liste.keySet()) {
				if(liste.get(key) != null) {
				for (V vertex : (Set<V>) liste.get(key)) {
					Set<V> setMarked = new HashSet<V>();
					setMarked.add((V) key);
					
					if(markedListe.containsKey(vertex)) {
						setMarked.addAll((Collection<? extends V>) markedListe.get(vertex));
					} 
					markedListe.put((V) vertex, setMarked);
					
					if (!getExistObject(markedListe, (V) key, (V) vertex)) {				
						Set<V> listTempo = new HashSet<V>();
						listTempo.add(vertex);
						if(returnListe.containsKey(key)) listTempo.addAll((Collection<? extends V>) returnListe.get(key));
						returnListe.put((V) key, listTempo);
					}
			    }
				} else {
					Set<V> listTempo = new HashSet<V>();
					returnListe.put((V) key, listTempo);
				}
			   

			}
			
			
			return returnListe;
		}
		
		protected boolean getExistObject(Map<V, Set<V>> set, V key, V vertex) {
			for(V test : set.keySet()) {
				if(test==key) {
					for (V test3 : (Set<V>) set.get(test)) {
						if(vertex==test3) return true;
					}
				}
			}
			return false;
			
		}
		
		public Set<V> addVertices(Set<? extends V> vertices) {
			Set<V> verticesNonAdded = new HashSet<V>();
			for(V test : vertices) {
				if(liste.containsKey(test))verticesNonAdded.add(test);
				else liste.put(test, null);
			}
			return verticesNonAdded;
		}
	}
