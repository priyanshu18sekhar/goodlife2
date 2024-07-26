package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class HealthArticleActivity extends AppCompatActivity {
    private TextView titleTextView;
    private TextView articleTitleTextView;
    private TextView articleContentTextView;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_article);

        titleTextView = findViewById(R.id.titleHome2);
        articleTitleTextView = findViewById(R.id.textView7);
        articleContentTextView = findViewById(R.id.HAListview);
        backButton = findViewById(R.id.buttonbackHA);

        titleTextView.setText("GOOD LIFE");

        int randomIndex = (int) (Math.random() * 6);
        String articleTitle = "";
        String articleContent = "";

        switch (randomIndex) {
            case 0:
                articleTitle = "Yoga: The Path to Inner Wellness";
                articleContent = "Yoga has been practiced for centuries in India and is renowned for its ability to harmonize the body, mind, and soul. Regular practice of yoga postures (asanas), breathing exercises (pranayama), and meditation can lead to improved physical and mental well-being.";
                break;
            case 1:
                articleTitle = "Ayurveda: Holistic Healing Practices";
                articleContent = "Ayurveda, the ancient Indian system of medicine, emphasizes a holistic approach to health and wellness. It utilizes natural remedies, herbal treatments, dietary guidelines, and lifestyle practices to prevent and treat various ailments.";
                break;
            case 2:
                articleTitle = "Meditation Techniques for Mental Clarity";
                articleContent = "Meditation is a powerful tool for achieving mental clarity, reducing stress, and enhancing overall well-being. By practicing mindfulness and focusing on the present moment, individuals can cultivate inner peace and tranquility.";
                break;
            case 3:
                articleTitle = "Healthy Eating Habits for a Balanced Life";
                articleContent = "Maintaining a healthy diet is essential for overall health and vitality. Incorporating a variety of fruits, vegetables, whole grains, and lean proteins into your meals can provide essential nutrients and promote optimal health.";
                break;
            case 4:
                articleTitle = "Daily Exercise Routine for Physical Fitness";
                articleContent = "Regular physical activity is key to maintaining a fit and active lifestyle. Engaging in activities such as walking, jogging, swimming, or cycling can improve cardiovascular health, strengthen muscles, and boost energy levels.";
                break;
            case 5:
                articleTitle = "Benefits of Traditional Indian Spices in Health";
                articleContent = "Indian spices not only enhance the flavor of dishes but also offer numerous health benefits. Spices like turmeric, cumin, and ginger have anti-inflammatory, antioxidant, and digestive properties that can support overall health.";
                break;
            default:
                break;
        }

        articleTitleTextView.setText(articleTitle);
        articleContentTextView.setText(articleContent);

        backButton.setOnClickListener(v -> {
            finish();
        });
    }
}
