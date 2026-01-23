# E-Commerce App avec FakeStore API

## Description
Application Androird développée en Kotlin avec Jetpack Compose, utilisant l'API [FakeStore](https://fakestoreapi.com/) pour afficher des produits et gérer un panier, filtrer par catégorie et gérer un panier avec une sauvegarde locale. 

**Objectif** : Offrir une expérience utilisateur fluide pour consulter des produits, les filtrer et les ajouter à un panier persistant.

---

##Fonctionnalités 
- Affichage des produits (grille + détails).
    - Grille de produits avec image, titre, prix et catégorie.
    - Ecran de détails pour chaque produit (description complète, image, etc.).
- Filtrage par catégorie.
    - Menu déroulant pour sélectionner une catégorie.
    - Mise à jour dynamique de la liste des produits.
- Panier avec sauvegarde locale.
    - Ajout/suppression de produits.
    - Calcul automatique du total.
    - Sauvegarde locale (avec **Room**). 
- Navigation entre écrans.
    - Passage fluide entre l'écran catalogue et les détails d'un produit.  

---

##Technologies
- **Langage** : Kotlin
    - Langage principal de l'application.
- **UI** : Jetpack Compose
    - Construction des interfaces utilisateur. 
- **Architecture** : MVVM
    - Séparation des responsabilités (View, ViewModel, Repository, Model).
- **Réseau** : Retrofit
    - Appels API 
- **Base de données** : Room
    - Sauvegarde locale des paniers
- **Asynchrone** : Coroutine
    - Gestion des appels réseau et des opérations longues. 

---

##Structure du projet 

```text
app/
├── src/
│   ├── main/
│   │   ├── java/com/example/android_ecommerce_faketore/
│   │   │   ├── data/
│   │   │   │   ├── model/          # Modèles de données (Product, CartItem)
│   │   │   │   ├── repository/     # Logique métier (ProductRepository, CartRepository)
│   │   │   │   └── database/       # Base de données Room (CartDao, AppDatabase)
│   │   │   ├── network/            # Appels API (Retrofit, FakeStoreApiService)
│   │   │   ├── ui/                 # Écrans Compose (ProductScreen, ProductDetailScreen)
│   │   │   └── viewmodel/          # ViewModels (ProductViewModel, CartViewModel)
│   │   └── res/                    # Ressources (images, layouts, etc.)
```


##Configuration
1. Cloner le dépôt.
2. Lancer l'application sur un émulateur ou un appareil physique. 

**Prérequis
- Android Studio 
- SDK API 24 "Nougat" 
- Connexion internet pour les appels API.

##UI
- 1 : écran catalogue 
    - Grille de produits avec filtre par catégorie.
- 2 : Détails d'un produit :
    - Affichage détaillé (image, titre, prix, description).

##Auteurs 
- **Backend** : MALEZIEUX Pierrette
- **Frontend** : MIHINDOU MIHINDOU Louis

