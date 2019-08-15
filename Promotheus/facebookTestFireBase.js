var firebaseConfig = {
                apiKey: "AIzaSyBuO_fb95XE0DaSS3BZ-rQ6GR5RvyPx89k",
                authDomain: "promotheus-248404.firebaseapp.com",
                databaseURL: "https://promotheus-248404.firebaseio.com",
                projectId: "promotheus-248404",
                storageBucket: "",
                messagingSenderId: "881620342120",
                appId: "1:881620342120:web:7cb3f62617ff2f90"
            };
            // Initialize Firebase
            firebase.initializeApp(firebaseConfig);
            
            function IngresoFacebook(){
                if(!firebase.auth().currentUser){
                    var provider = new firebase.auth.FacebookAuthProvider();
                    
                    provider.addScope('public_profile');
                    
                    firebase.auth().signInWithPopup(provider).then (function(result){
                        var token = result.credential.accesstoken;
                        
                        var user = result.user;
                        
                        console.log(user);
                        
                        $('#page').css('display','none') && $('#page2').css('display','block');
                        
                        document.querySelector("span.mdl-layout-title").textContent = "Bienvenido "+name;
                    }).catch (function (error) {
                        var erroCode = error.code;
                        
                        var errorMessage = eror.message;
                        
                        var erroremail= error.email;
                        
                        var credential = error.credential;
                        
                        if(errorCode==='auth/account-exists-with-different-credential'){
                            alert('Es el mismo usuario');
                        }
                    });
                }else{
                    firebase.auth().signOut();
                }
            }
            
            document.getElementById('btn-facebook').addEventListener('click',IngresoFacebook,false);